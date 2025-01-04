package LC0020_ValidParentheses

func isValid(s string) bool {
	n := len(s)
	if n%2 == 1 {
		return false
	}

	mp := map[byte]byte{
		')': '(',
		']': '[',
		'}': '{',
	}
	stack := make([]byte, 0)
	for i := 0; i < n; i++ {
		if _, ok := mp[s[i]]; ok {
			if len(stack) == 0 || stack[len(stack)-1] != mp[s[i]] {
				return false
			}
			stack = stack[:len(stack)-1]
		} else {
			stack = append(stack, s[i])
		}
	}
	return len(stack) == 0
}