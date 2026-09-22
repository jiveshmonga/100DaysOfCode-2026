def sort_crates(weights):
    # BUG 1 FIXED: Sort in ascending order to prioritize lighter crates
    return sorted(weights, reverse=False)


def can_load(current_weight, crate_weight, limit):
    if current_weight + crate_weight <= limit:
        return True
    return False


def load_rebel_cargo(weights, limit):
    sorted_weights = sort_crates(weights)

    selected_crates = []
    total_weight = 0
    # BUG 2 FIXED: Start count at 0
    crate_count = 0 

    for crate_weight in sorted_weights:

        can_add = can_load(
            total_weight,
            crate_weight,
            limit
        )

        if can_add:
            # BUG 3 FIXED: Add to the total weight instead of overwriting
            total_weight += crate_weight 

            selected_crates.append(
                crate_weight
            )

            crate_count += 1

        else:
            # Optimal tweak: Stop completely once the limit is reached
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

# BUG 4 FIXED: Make the limit an integer, not a string
cargo_limit = 10 

selected_crates, crates_loaded, total_weight = prepare_mission(
    cargo_weights,
    cargo_limit
)

# BUG 5 FIXED: Added proper line breaks (syntax)
print("Crates loaded:", crates_loaded)
print("Selected crates:", selected_crates)
print("Total weight:", total_weight)