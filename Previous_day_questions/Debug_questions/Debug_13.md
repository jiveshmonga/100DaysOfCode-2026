<h2 align="center">Week 13 Day 7 (13/09/2026) — Weekly Debug 13</h2>

## 1. The Rebel Cargo Mission

The Rebel Alliance must quickly load emergency supply crates onto the Millennium Falcon before the Imperial fleet reaches their secret base. The Falcon has a strict cargo limit, and every crate has a different weight.

To carry the maximum possible number of crates, the Rebel loading system should use a greedy strategy and prioritize lighter crates. However, R2-D2 discovers that the cargo management program has been damaged during an Imperial attack.

The program contains exactly five bugs. Repair the code so the Falcon loads the maximum number of crates without exceeding its cargo limit.

This problem helps build concepts like:
- Greedy algorithms
- Sorting
- List traversal
- Conditional selection
- Accumulation and counting

which are important for solving optimization problems efficiently.

**Your task:** Identify and fix all bugs in the given code so that it loads the maximum number of crates without exceeding the cargo limit and produces the expected output.

### What the Code Must Do

- Sort the crate weights in ascending order.
- Use a greedy strategy to select the maximum number of crates.
- Never allow the total weight to exceed the cargo limit.
- Track the selected crates and calculate their total weight.
- Display the final result exactly as shown.

### Constraints

- Do not add any new functions.
- Do not remove existing statements.
- Fix all logical, syntax and runtime errors.
- The solution must use a greedy approach.
- The output must match exactly.

### Examples

**Output:**
```text
Crates loaded: 3
Selected crates: [2, 3, 4]
Total weight: 9
```

### Buggy Code

```python
def sort_crates(weights):
return sorted(weights, reverse=True)

def can_load(current_weight, crate_weight, limit):
if current_weight + crate_weight <= limit:
return True
return False

def load_rebel_cargo(weights, limit):
sorted_weights = sort_crates(weights)
selected_crates = []
total_weight = 0
crate_count = 1

for crate_weight in sorted_weights:
can_add = can_load(
total_weight,
crate_weight,
limit
)

if can_add:
total_weight = crate_weight
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

cargo_limit = "10"

selected_crates, crates_loaded, total_weight = prepare_mission(
cargo_weights,
cargo_limit
)

print("Crates loaded:", crates_loaded)
print("Selected crates:", selected_crates)
print("Total weight:", total_weight)
```
