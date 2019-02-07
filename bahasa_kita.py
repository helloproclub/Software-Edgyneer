import json
import os
import sys
import time
import platform
from colorama import init

init(autoreset=True)
running = True

def clear():
	if platform.system() == 'Windows':
		os.system('cls')
	elif platform.system() == 'Linux':
		os.system('clear')

def header():
	print()
	print('============================================'.center(os.get_terminal_size().columns))
	print('===               \033[31mNUSANTARA\033[0m              ==='.center(os.get_terminal_size().columns+9))
	print('===             - terjemahan -           ==='.center(os.get_terminal_size().columns))
	print('============================================'.center(os.get_terminal_size().columns))
	print()

def buat(bahasa, kata, arti):
	try:
		try:
			with open('data.json','r') as f:
				data = json.load(f)

				if len(data[bahasa]) > 0:
					data[bahasa].append({
						'kata':kata,
						'arti':arti
					})
		except:
			data = {}
			data[bahasa] = []
			data[bahasa].append({
				'kata':kata,
				'arti':arti
			})

		with open('data.json','w+') as f:
			json.dump(data, f)

	except Exception as e:
		try:
			et, ev, tb = sys.exc_info()
			lineno = tb.tb_lineno
			fn = tb.tb_frame.f_code.co_filename
			print("[Digampar Realita] %s Line %i - %s"% (fn, lineno, str(e)))
			return
		except:
			print("Undescribeable error detected!!")
			return

def arti(bahasa, kata):
	try:
		res = list()
		kalimat = kata.split(' ')

		with open('data.json','r') as f:
			data = json.load(f)
			for i in data[bahasa]:
				if i['kata'] == kata.lower():
					res.append(i['arti'])
		
		if len(res) > 0:
			print()
			print('[\033[32m'+lang.upper()+'\033[0m]')
			print(res[0].capitalize())
			if len(res) > 1:
				print()
				print('\033[36mAlternatif\033[0m: '+', '.join(res[1:]))
			print()
			jawab = input('[\033[33m?\033[0m] Puas dengan terjemahan ini? (Y/n): ')
			if jawab.lower() == 'y':
				print('Senang membantu anda.')
				time.sleep(2)
			elif jawab.lower() == 'n':
				sedia = input('[\033[33m?\033[0m] Apakah anda mau membantu menerjemahkan? (Y/n): ')
				if sedia.lower() == 'y':
					arti = input('[\033[33m?\033[0m] Apakah arti dari kata "\033[35m'+kata+'\033[0m"?: ')
					buat(lang, kata.lower(), arti.lower())
					print('Kamus telah ditambahkan!')
					time.sleep(2)
				elif sedia.lower() == 'n':
					print('Terima Kasih')
					time.sleep(2)
		else:
			if len(kalimat) > 1:
				hasil = list()
				for r in kalimat:
					with open('data.json') as f:
						data = json.load(f)
						for i in data[lang]:
							if i['kata'] == r:
								if len(hasil) < 1:
									hasil.append(kata.replace(r,i['arti']))
								else:
									terjemah = hasil[0]
									del(hasil[0])
									hasil.append(terjemah.replace(r,i['arti']))
				print()
				print('[\033[32m'+lang.upper()+'\033[0m]')
				print(hasil[0])
				print()
				jawab = input('[\033[33m?\033[0m] Puas dengan terjemahan ini? (Y/n): ')
				if jawab.lower() == 'y':
					print('Senang membantu anda.')
					time.sleep(2)
				elif jawab.lower() == 'n':
					sedia = input('[\033[33m?\033[0m] Apakah anda mau membantu menerjemahkan? (Y/n): ')
					if sedia.lower() == 'y':
						arti = input('[\033[33m?\033[0m] Apakah arti dari kata "\033[35m'+kata+'\033[0m"?: ')
						buat(lang, kata.lower(), arti.lower())
						print('Kamus telah ditambahkan!')
						time.sleep(2)
					elif sedia.lower() == 'n':
						print('Terima Kasih')
						time.sleep(2)
			else:
				print()
				print('[\033[31m!\033[0m] Kata "\033[35m'+kata+'\033[0m" belum diterjemahkan.')
				jawab = input('[\033[33m?\033[0m] Apakah anda mau menerjemahkan? (Y/n): ')
				if jawab.lower() == 'y':
					arti = input('[\033[33m?\033[0m] Apakah arti dari kata "\033[35m'+kata+'\033[0m"?: ')
					buat(lang, kata.lower(), arti.lower())
					print('Kamus telah ditambahkan!')
				elif jawab.lower() == 'n':
					print('OK!')
				time.sleep(2)
	except Exception as e:
		print()
		print('[\033[31m!\033[0m] Kata "\033[35m'+kata+'\033[0m" belum diterjemahkan.')
		jawab = input('[\033[33m?\033[0m] Apakah anda mau menerjemahkan? (Y/n): ')
		if jawab.lower() == 'y':
			arti = input('[\033[33m?\033[0m] Apakah arti dari kata "\033[35m'+kata+'\033[0m"?: ')
			buat(lang, kata.lower(), arti.lower())
			print('Kamus telah ditambahkan!')
		elif jawab.lower() == 'n':
			print('OK!')
		time.sleep(2)

while running:
	clear()
	header()
	print('Silahkan pilih bahasa yang akan ditranslate: ')
	print()
	print('[\033[32m1\033[0m] Bahasa Bugis')
	print('[\033[32m2\033[0m] Bahasa Sunda')
	print('[\033[32m3\033[0m] Bahasa Jawa')
	print('[\033[32m4\033[0m] Bahasa Madura')
	print('[\033[32m5\033[0m] Bahasa Aceh')
	print()
	print('[\033[31mQ\033[0m] \033[31mKeluar')
	print()
	bahasa = input('Pilihan: ')
	
	try:
		if bahasa.lower() == 'q':
			print('Good Bye')
			sys.exit()

		elif int(bahasa) == 1:
			lang = 'bugis'

		elif int(bahasa) == 2:
			lang = 'sunda'

		elif int(bahasa) == 3:
			lang = 'jawa'

		elif int(bahasa) == 4:
			lang = 'madura'

		elif int(bahasa) == 5:
			lang = 'aceh'
			
		clear()
		header()
		s = '\033[31mINDONESIA \033[0m-> \033[32m'+lang.upper()
		print(s.center(os.get_terminal_size().columns+13))
		print()
		print('[\033[31mINDONESIA\033[0m]')
		kata = input()
		arti(lang, kata)

	except Exception as e:
		try:
			et, ev, tb = sys.exc_info()
			lineno = tb.tb_lineno
			fn = tb.tb_frame.f_code.co_filename
			print("[Digampar Realita] %s Line %i - %s"% (fn, lineno, str(e)))
			input()
		except:
			print("Undescribeable error detected!!")