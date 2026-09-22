#include <stdlib.h>
#include <stdbool.h>

typedef struct {
    int q1[100];
    int q2[100];
    int front1, rear1;
    int front2, rear2;
} MyStack;

MyStack* myStackCreate() {
    MyStack* obj = (MyStack*)malloc(sizeof(MyStack));

    obj->front1 = 0;
    obj->rear1 = -1;

    obj->front2 = 0;
    obj->rear2 = -1;

    return obj;
}

void myStackPush(MyStack* obj, int x) {
    obj->q1[++obj->rear1] = x;
}

int myStackPop(MyStack* obj) {
    // Move all elements except the last one
    // from q1 to q2
    while (obj->front1 < obj->rear1) {
        obj->q2[++obj->rear2] = obj->q1[obj->front1++];
    }

    // The last element is the top of the stack
    int result = obj->q1[obj->front1];

    // Remove it
    obj->front1++;
    
    // Swap q1 and q2
    int temp;

    temp = obj->front1;
    obj->front1 = obj->front2;
    obj->front2 = temp;

    temp = obj->rear1;
    obj->rear1 = obj->rear2;
    obj->rear2 = temp;

    return result;
}

int myStackTop(MyStack* obj) {
    // Move all elements except the last one
    while (obj->front1 < obj->rear1) {
        obj->q2[++obj->rear2] = obj->q1[obj->front1++];
    }

    // Last element is the top
    int result = obj->q1[obj->front1];

    // Move the last element also to q2
    obj->q2[++obj->rear2] = result;
    obj->front1++;

    // Swap queues
    int temp;

    temp = obj->front1;
    obj->front1 = obj->front2;
    obj->front2 = temp;

    temp = obj->rear1;
    obj->rear1 = obj->rear2;
    obj->rear2 = temp;

    return result;
}

bool myStackEmpty(MyStack* obj) {
    return obj->front1 > obj->rear1;
}

void myStackFree(MyStack* obj) {
    free(obj);
}