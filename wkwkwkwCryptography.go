package main

import (
	"fmt"
)

func encryptingMessage(secretMessage string, cipherKey int) {
	countCharacterMessage := len(secretMessage)
	cipher := rune(cipherKey)
	fmt.Print("\nEncrypted Secret Message = ")
	for i := 0; i < countCharacterMessage; i++ {
		getEncryptedMessage := string([]rune(secretMessage)[i] + cipher)
		fmt.Print(getEncryptedMessage)
	}
}

func decryptingMessage(secretMessage string, cipherKey int) {
	countCharacterMessage := len(secretMessage) 
	cipher := rune(cipherKey)
	fmt.Print("\nDecrypted Secret Message = ")
	for i := 0; i < countCharacterMessage; i++ {
		getDecryptedMessage := string([]rune(secretMessage)[i] - cipher)
		fmt.Print(getDecryptedMessage)
	}
}


func main() {
	var message string
	var key, choise int
	exit := false
	for exit == false {
		fmt.Printf("MENU CAESAR CRYPTOGRAPHY\n")
		fmt.Printf("1. Encrypring\n");
		fmt.Printf("2. Decrypting\n")
		fmt.Printf("3. Exit\n")
		fmt.Printf("Enter your choise : ")
		fmt.Scanln(&choise)
	
		switch choise {
			case 1:
				fmt.Printf("Enter your secret message (Without space) : ")
				fmt.Scanln(&message)
				fmt.Printf("Enter secret key : ")
				fmt.Scanln(&key)
				encryptingMessage(message, key)
				break
			case 2:
				fmt.Printf("Enter your secret message (Without space) : ")
				fmt.Scanln(&message)
				fmt.Printf("Enter secret key : ")
				fmt.Scanln(&key)
				decryptingMessage(message, key)
			case 3:
				exit = true
			default:
				fmt.Print("Your choise is wrong")
		}
		fmt.Println(" ")
	}
}

