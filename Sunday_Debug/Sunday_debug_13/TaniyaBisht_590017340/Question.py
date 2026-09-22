
def sort_crates(weights):
    #Sort in ascending order
    return sorted(weights)
def can_load(current_weight, crate_weight, limit):
    if current_weight + crate_weight <= limit:
        return True
    return False
def load_rebel_cargo(weights, limit):
    sorted_weights = sort_crates(weights)
    selected_crates = []
    total_weight = 0
    #Start count from 0
    crate_count = 0
    for crate_weight in sorted_weights:
        can_add = can_load(
            total_weight,
            crate_weight,
            limit
        )
        if can_add:
            #Add instead of replacing
            total_weight += crate_weight
            selected_crates.append(crate_weight)
            #Count selected crate
            crate_count += 1
        else:
            continue
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
#String "10" → integer 10
cargo_limit = 10
selected_crates, crates_loaded, total_weight = prepare_mission(
    cargo_weights,
    cargo_limit
)
print("Crates loaded:", crates_loaded)
print("Selected crates:", selected_crates)
print("Total weight:", total_weight)