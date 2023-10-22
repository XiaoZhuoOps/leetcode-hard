package Lc127

import llq "github.com/emirpasic/gods/queues/linkedlistqueue"

// 1.bfs 双源最短路
// 2.邻接矩阵 vis1 vis2 queue
// 3.
// 4. debug
// hit -> hot ->
// cog -> dog log
//
func ladderLength(beginWord string, endWord string, wordList []string) int {
	flag := false
	for _, word := range wordList {
		if word == endWord {
			flag = true
			break
		}
	}
	if !flag {
		return 0
	}
	isAdj := func(a string, b string) bool {
		num := 0
		for i := range a {
			if a[i] != b[i] {
				num += 1
			}
		}
		return num == 1
	}
	vis1 := make(map[string]struct{})
	vis2 := make(map[string]struct{})
	vis1[beginWord] = struct{}{}
	vis2[endWord] = struct{}{}

	queue := llq.New()
	queue.Enqueue(beginWord)
	queue.Enqueue(endWord)
	step := 0
	for queue.Size() > 0 {
		l := queue.Size()
		for i := 0; i < l; i++ {
			dq, _ := queue.Dequeue()
			ele := dq.(string)
			if _, ok := vis1[ele]; ok {
				for _, word := range wordList {
					if _, ok := vis1[word]; ok {
						continue
					}
					if isAdj(ele, word) {
						if _, ok := vis2[word]; ok {
							return 2*step + 1 + 1
						} else {
							queue.Enqueue(word)
							vis1[word] = struct{}{}
						}
					}
				}
			} else {
				for _, word := range wordList {
					if _, ok := vis2[word]; ok {
						continue
					}
					if isAdj(ele, word) {
						if _, ok := vis1[word]; ok {
							return 2*step + 1 + 1 + 1
						} else {
							queue.Enqueue(word)
							vis2[word] = struct{}{}
						}
					}
				}
			}
		}
		step += 1
	}
	return 0
}
