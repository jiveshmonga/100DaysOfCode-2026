#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <ctype.h>

#define MAX 100

char* postfixToPrefix(char* s) {
    char* stack[MAX];
    int top = -1;

    for (int i = 0; s[i] != '\0'; i++) {

        // If operand, push it onto stack
        if (isalpha(s[i])) {
            char* temp = (char*)malloc(2 * sizeof(char));
            temp[0] = s[i];
            temp[1] = '\0';

            stack[++top] = temp;
        }

        // If operator
        else {
            // Pop two operands
            char* op2 = stack[top--];
            char* op1 = stack[top--];

            // Create prefix expression
            char* temp = (char*)malloc(
                (strlen(op1) + strlen(op2) + 2) * sizeof(char)
            );

            temp[0] = s[i];
            temp[1] = '\0';

            strcat(temp, op1);
            strcat(temp, op2);

            // Push result back
            stack[++top] = temp;

            free(op1);
            free(op2);
        }
    }

    return stack[top];
}

int main() {
    char s[] = "ABC/-AK/L-*";

    char* result = postfixToPrefix(s);

    printf("Prefix: %s\n", result);

    free(result);

    return 0;
}