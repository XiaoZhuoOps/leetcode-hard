package deque

// Deque 是用于存放 any 的队列
type Deque struct {
	nums []any
}

// NewQueue 返回 *kit.Deque
func NewQueue() *Deque {
	return &Deque{nums: []any{}}
}

// PushLeft 把 n 放入队列
func (q *Deque) PushLeft(n any) {
	q.nums = append(q.nums, n)
}

// PopRight 从 q 中取出最先进入队列的值
func (q *Deque) PopRight() any {
	res := q.nums[0]
	q.nums = q.nums[1:]
	return res
}

// Len 返回 q 的长度
func (q *Deque) Len() int {
	return len(q.nums)
}

// IsEmpty 反馈 q 是否为空
func (q *Deque) IsEmpty() bool {
	return q.Len() == 0
}
