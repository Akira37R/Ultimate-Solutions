package contains_duplicate_ii

func containsNearbyDuplicate(nums []int, k int) bool {
	m := make(map[int]int) // nums[i] -> i
	for i, v := range nums {
		if j, ok := m[v]; ok && i-j <= k {
			return true
		}
		m[v] = i
	}
	return false
}
