#include <stdio.h>

int maxEnergy(int N, int energy[])
{
    if (N == 1)
        return energy[0];

    int prev2 = energy[0];
    int prev1 = energy[1] + energy[0];

    for (int i = 2; i < N; i++)
    {
        int current = energy[i] + (prev1 > prev2 ? prev1 : prev2);

        prev2 = prev1;
        prev1 = current;
    }

    return prev1;
}

int main()
{
    int N = 6;
    int energy[] = {5, 10, 20, 15, 25, 30};

    printf("Maximum energy: %d\n", maxEnergy(N, energy));

    return 0;
}