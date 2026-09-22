#include <stdio.h>
#include <stdlib.h>
#include <string.h>

char* removeOuterParentheses(char* s) {
    int n = strlen(s);

    char* result = (char*)malloc((n + 1) * sizeof(char));

    int depth = 0;
    int j = 0;

    for (int i = 0; i < n; i++) {

        if (s[i] == '(') {
            // Add '(' only if it is NOT the outermost one
            if (depth > 0) {
                result[j++] = s[i];
            }
            depth++;
        }

        else {
            depth--;

            // Add ')' only if it is NOT the outermost one
            if (depth > 0) {
                result[j++] = s[i];
            }
        }
    }

    result[j] = '\0';

    return result;
}