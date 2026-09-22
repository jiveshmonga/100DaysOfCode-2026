int minEatingSpeed(int* piles, int pilesSize, int h) {
    int high = 0;
    long long sum = 0;

    for (int i = 0; i < pilesSize; i++) {
        if (piles[i] > high)
            high = piles[i];
        sum += piles[i];
    }

    int low = (int)((sum + h - 1) / h);

    while (low < high) {
        int k = low + (high - low) / 2;
        long long hours = 0;

        for (int i = 0; i < pilesSize; i++) {
            hours += (piles[i] + k - 1) / k;

            if (hours > h)
                break;
        }

        if (hours <= h)
            high = k;
        else
            low = k + 1;
    }

    return low;
}