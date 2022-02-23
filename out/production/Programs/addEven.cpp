#include <iostream>

int main() {
    // Write C++ code here

    int a;
    std::cin>> a;
    
    int i = 2;
    int sum = 0;
    
    while(i<=a){
        sum += i;
        i +=2;
    }
    
    std::cout<< sum;


    return 0;
}