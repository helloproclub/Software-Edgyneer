
#include <iostream>
#include <vector>
using namespace std;

    char block = char(219);

    int width; 
    int height;
    vector<vector<int>> arr = {};
    vector<vector<int>> arr2 = {};
    vector<vector<int>> map = {};
    int row = 1;
    int col = 1; 
    vector<int> nxt = {};
    int count = 1;
    
// Generate Maze
int create(){
    map.clear();
    if (count >= (height / 2) * (width / 2)){ 
        return 0;
    }
    if (row+2 < height-1 && arr[row+2][col] == 0){
        map.push_back({row+2,col}); //down
    }
    if (row-2 > 0 && arr[row-2][col] == 0 ){
        map.push_back({row-2,col}); //up
    }
    if (col+2 < width-1 && arr[row][col+2] == 0){
        map.push_back({row,col+2}); //right
    }
    if (col-2 > 0 && arr[row][col-2] == 0){
        map.push_back({row,col-2}); //left
    } 
    if (map.size() > 0){
        nxt.clear();
        nxt = map[rand()%map.size()];
        arr[nxt[0]][nxt[1]] = 2;
        count++;
        arr2.push_back(nxt);
        if (col-nxt[1] < 0){
            arr[row][col+1] = 0;
            col+=2;create();
        }
        else if (col-nxt[1] > 0){
            arr[row][col-1] = 0;
            col-= 2; create();
        }
        else if (row-nxt[0] < 0){
            arr[row+1][col] = 0;
            row+= 2;create();
        }
        else if (row-nxt[0] > 0){
            arr[row-1][col] = 0;
            row-= 2;create();
        }  
    }
    else if (arr2.size() > 0){
        arr2.pop_back();
        row = arr2[arr2.size()-1][0] ;
        col = arr2[arr2.size()-1][1] ;
        create();
    }
    return 0;
}

int main() {
    
    //Input height and width for maze size
    cin >> height;
    cin >> width;
    //Adjusting size
    if (height%2 == 0){ height++; } 
    if (width%2 == 0){ width++; }
    
    //Create the base of the maze
    arr.resize(height);
    for (int j = 0; j < height; j++){
        arr[j].resize(width);
        for (int i = 0; i < width; i++){
            if (j%2 == 1 && i%2 == 1){
                arr[j][i] = 0;
            }
            else if ((j == 0 && i == 1) || (j == height-1 && i == width-2)){
                arr[j][i] = 0;
            }
            else {
                arr[j][i] = 1;
            }
        }
    }
        
    create();

    //Print maze
    for (int j = 0; j < height; j++){
        for (int i = 0; i < width; i++){
            if (arr[j][i] == 1)
                cout << block;
            else if (j == 0 && i == 1)
                cout << "S";
            else if (j == height-1 && i == width-2)
                cout << "F";
            else {
                if( arr[j][i] == 2)
                    arr[j][i] = 0;
                cout << " ";
            }
        }
        cout << "\n";
    }
    return 0;
}
