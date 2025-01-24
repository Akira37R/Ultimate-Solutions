package minimum_number_of_coins_for_fruits

func minimumCoins(prices []int) int {
	n := len(prices)
	queue := [][2]int{{n, 0}}

	for i := n - 1; i >= 0; i-- {
		for len(queue) > 0 && queue[len(queue)-1][0] >= 2*i+3 {
			queue = queue[:len(queue)-1]
		}
		cur := queue[len(queue)-1][1] + prices[i]
		for len(queue) > 0 && queue[0][1] >= cur {
			queue = queue[1:]
		}
		queue = append([][2]int{{i, cur}}, queue...)
	}

	return queue[0][1]
}
