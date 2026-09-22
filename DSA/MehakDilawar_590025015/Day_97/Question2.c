//Find the maximum total energy a robot can collect while moving from floor 1 to floor N by taking 1 or 2 floors at a time.
//Input:N=6, energy=[5,10,20,15,25,30]. Output:105
#include <stdio.h>

int maxEnergy(int energy[], int n) {
    if (n == 1)
        return energy[0];
    int dp[n];
    dp[0] = energy[0];
    dp[1] = energy[0] + energy[1];
    for (int i = 2; i < n; i++) {
        int maxPrev = (dp[i - 1] > dp[i - 2]) 
                      ? dp[i - 1] : dp[i - 2];

        dp[i] = energy[i] + maxPrev;
    }
    return dp[n - 1];
}

int main() {
    int n;
    printf("Enter number of floors: ");
    scanf("%d", &n);
    int energy[n];
    printf("Enter energy on each floor:\n");
    for (int i = 0; i < n; i++) {
        scanf("%d", &energy[i]);
    }
    printf("Maximum Energy = %d\n", maxEnergy(energy, n));
return 0;
}