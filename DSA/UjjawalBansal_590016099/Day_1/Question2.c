#include <stdio.h>

int sum_array(int* arr, int size) {
    int s =0;
    for (int i=0; i<size; i++) {
        s += arr[i];
    }
    return s;
}