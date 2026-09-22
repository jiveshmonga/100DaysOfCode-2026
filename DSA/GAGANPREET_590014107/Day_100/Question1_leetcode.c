int minEatingSpeed(int* piles, int pilesSize, int h) {
    int low = 1;
    int high = 0;

    // Find maximum pile
    for (int i = 0; i < pilesSize; i++) {
        if (piles[i] > high)
            high = piles[i];
    }

    // Binary Search
    while (low < high) {
        int mid = low + (high - low) / 2;

        long long hours = 0;

        for (int i = 0; i < pilesSize; i++) {
            hours += (piles[i] + mid - 1) / mid;

            if (hours > h)
                break;
        }

        if (hours <= h)
            high = mid;       // Try smaller speed
        else
            low = mid + 1;    // Need faster speed
    }

    return low;
}
