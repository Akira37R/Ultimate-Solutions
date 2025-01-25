package minimum_money_required_before_transactions

func minimumMoney(transactions [][]int) int64 {
	var totalLose int64 = 0
	var res int = 0
	for _, t := range transactions {
		cost, cashback := t[0], t[1]
		totalLose += int64(max(cost-cashback, 0))
		res = max(res, min(cost, cashback))
	}
	return totalLose + int64(res)
}
