fn main() {
    println!(
        "{:?}",
        Solution::insert(vec![vec![1, 3], vec![6, 9]], vec![2, 5])
    );
    println!(
        "{:?}",
        Solution::insert(
            vec![
                vec![1, 2],
                vec![3, 5],
                vec![6, 7],
                vec![8, 10],
                vec![12, 16]
            ],
            vec![4, 8]
        )
    );
}

struct Solution {}
impl Solution {
    pub fn insert(intervals: Vec<Vec<i32>>, new_interval: Vec<i32>) -> Vec<Vec<i32>> {
        let mut added = false;
        let mut new_interval = new_interval.clone();

        let mut updated_intervals = Vec::with_capacity(intervals.len() + 1);
        for interval in intervals.into_iter() {
            if (!added && interval[1] < new_interval[0]) || added {
                updated_intervals.push(interval);
            } else if interval[0] > new_interval[1] {
                updated_intervals.push(new_interval.clone());
                updated_intervals.push(interval);
                added = true;
            } else {
                if interval[0] < new_interval[0] {
                    new_interval[0] = interval[0];
                }
                if interval[1] > new_interval[1] {
                    new_interval[1] = interval[1];
                }
            }
        }

        if !added {
            updated_intervals.push(new_interval)
        }

        updated_intervals
    }
}
