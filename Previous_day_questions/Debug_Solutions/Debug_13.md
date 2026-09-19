<h2 align="center">Week 13 Day 7 (13/09/2026) — Weekly Debug 13</h2>

## 1. The Rebel Cargo Mission

### Solution


### Fixed Code

```python
def sort_crates(weights):
    # BUG: return sorted(weights, reverse=True)
    return sorted(weights)


def can_load(current_weight, crate_weight, limit):
    if current_weight + crate_weight <= limit:
        return True
    return False


def load_rebel_cargo(weights, limit):
    sorted_weights = sort_crates(weights)
    selected_crates = []
    total_weight = 0
    # BUG: crate_count = 1
    crate_count = 0

    for crate_weight in sorted_weights:
        can_add = can_load(
            total_weight,
            crate_weight,
            limit
        )

        if can_add:
            # BUG: total_weight = crate_weight
            total_weight += crate_weight
            selected_crates.append(
                crate_weight
            )
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

# BUG: cargo_limit = "10"
cargo_limit = 10

selected_crates, crates_loaded, total_weight = prepare_mission(
    cargo_weights,
    cargo_limit
)

print("Crates loaded:", crates_loaded)
print("Selected crates:", selected_crates)
print("Total weight:", total_weight)
```

### Output

```text
Crates loaded: 3
Selected crates: [2, 3, 4]
Total weight: 9
```

### Explanation

- **Ascending Sort:** `sorted(weights)` arranges the crates from lightest to heaviest, which is required for maximizing the number of crates that fit within a fixed cargo limit.
- **Greedy Selection:** Each crate is considered in ascending order. If adding it does not exceed the cargo limit, it is selected.
- **Weight Accumulation:** `total_weight += crate_weight` maintains the combined weight of all selected crates.
- **Crate Counting:** The count starts at `0` and increases only when a crate is successfully loaded.
- **Correct Data Type:** The cargo limit must be an integer so it can be used in arithmetic and comparisons.


