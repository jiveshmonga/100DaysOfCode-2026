#include <stdio.h>

// Sets the bit at position pos
int setBit(int mask, int pos) {
    return mask | (1u << pos); // FIX: OR sets only the required bit without changing others
}

// Tests if the bit at position pos is set
int testBit(int mask, int pos) {
    return (mask & (1u << pos)) != 0; // FIX: AND checks the bit and returns exactly 1 or 0
}

// Clears the bit at position pos
int clearBit(int mask, int pos) {
    return mask & ~(1u << pos); // FIX: Changed | to & so only the selected bit is cleared
}

// Toggles the bit at position pos
int toggleBit(int mask, int pos) {
    return mask ^ (1u << pos); // FIX: Changed & to ^ because XOR flips the selected bit
}

// Counts number of set bits in mask 
int countAwakened(int mask) {
    int count = 0;
    unsigned int value = (unsigned int)mask; // FIX: Use unsigned value so negative masks are handled correctly

    while (value > 0) {
        count += value & 1u;   // FIX: Count the current bit if it is set
        value >>= 1;           // FIX: Shift right to check the next bit
    }

    return count;
}

int main() {
    int mainframeMask = 0;

    mainframeMask = setBit(mainframeMask, 0); // Neo awakens
    mainframeMask = setBit(mainframeMask, 3); // Morpheus awakens
    mainframeMask = setBit(mainframeMask, 5); // Trinity awakens

    printf("%d\n", testBit(mainframeMask, 3)); 
    printf("%d\n", testBit(mainframeMask, 1)); 

    mainframeMask = clearBit(mainframeMask, 3); // Morpheus captured
    printf("%d\n", testBit(mainframeMask, 3)); 

    mainframeMask = toggleBit(mainframeMask, 5); // Smith overwrites Trinity's slot
    printf("%d\n", testBit(mainframeMask, 5));

    printf("%d\n", countAwakened(mainframeMask)); 

    return 0;
}