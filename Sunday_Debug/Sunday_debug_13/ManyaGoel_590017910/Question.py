# FIX 1: Changed reverse=True to normal sorted() because the greedy approach should always pick the lightest crates first.
def sort_crates(weights):
    return sorted(weights, reverse=False)


def can_load(current_weight, crate_weight, limit):
    if current_weight + crate_weight <= limit:
        return True
    return False


def load_rebel_cargo(weights, limit):
    sorted_weights = sort_crates(weights)

    selected_crates = []
    total_weight = 0

    # FIX 2: Changed 1 to 0 because initially no crates have been selected.
    crate_count = 0

    for crate_weight in sorted_weights:

        can_add = can_load(
            total_weight,
            crate_weight,
            limit
        )

        if can_add:

            # FIX 3: Changed = to += so each crate's weight is added to the existing total instead of replacing it.
            total_weight += crate_weight

            selected_crates.append(
                crate_weight
            )

            crate_count += 1

        else:
            break #FIX 4: Changed continue to break because weights are sorted ascending - once a crate is too heavy to fit, every remaining crate is even heavier and won't fit either, so continuing further is wasted work.

    return selected_crates, crate_count, total_weight


def prepare_mission(weights, limit):
    selected, count, total = load_rebel_cargo(
        weights,
        limit
    )

    return selected, count, total


cargo_weights = [
    2,
    3,
    5,
    4,
    6
]

# FIX 5: Changed "10" to 10 because the cargo limit must be an integer not string, otherwise Python cannot compare it correctly with integer weights.
cargo_limit = 10


selected_crates, crates_loaded, total_weight = prepare_mission(
    cargo_weights,
    cargo_limit
)

print("Crates loaded:", crates_loaded)
print("Selected crates:", selected_crates)
print("Total weight:", total_weight)