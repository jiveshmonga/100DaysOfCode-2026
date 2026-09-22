#include <stdio.h>

// Function to calculate the sum of elements in an array
int sum(int a[], int size) {
    int sum = 0; // Initialize sum to 0
    
    // Iterate through the array and add each element to sum
    for (int i = 0; i < size; i++) {
        sum += a[i];
    }
    
    return sum; // Return the calculated sum
}

int main(){
    int size;

    // Read the size of the array from the user
    scanf("%d", &size);

    // Declare an array of the given size (Variable Length Array)
    int array[size];
    
    // Read the array elements from the user
    for(int j = 0; j < size; j++){
        scanf("%d", &array[j]);
    }

    // Calculate and print the sum of the array elements
    printf("%d", sum(array, size));
    
    return 0;
}