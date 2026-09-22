def sort_crates(weights):
    # Fix -> Sort in ascending order to prioritize lighter crates
    return sorted(weights, reverse=False)


def can_load(current_weight, crate_weight, limit):
    if current_weight + crate_weight <= limit:
        return True
    return False


def load_rebel_cargo(weights, limit):
    sorted_weights = sort_crates(weights)

    selected_crates = []
    total_weight = 0
    # Fix 2 -> Initialize crate_count to 0 instead of 1
    crate_count = 0

    for crate_weight in sorted_weights:

        can_add = can_load(
            total_weight,
            crate_weight,
            limit
        )

        if can_add:
            # Fix 3 -> Add to the total weight instead of overwriting it
            total_weight += crate_weight

            selected_crates.append(
                crate_weight
            )

            crate_count += 1

        else:
            # Fix 4 -> Break the loop if the crate cannot be added, as we cannot load any more crates
            break

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

# Fix 5 -> Define cargo_limit as an integer, not a string
cargo_limit = 10

selected_crates, crates_loaded, total_weight = prepare_mission(
    cargo_weights,
    cargo_limit
)

print("Crates loaded:", crates_loaded)
print("Selected crates:", selected_crates)
print("Total weight:", total_weight)