package Lc1723

import (
	"fmt"
	"testing"
)

func Test_Lc1723(t *testing.T) {
	jobs := []int{254, 256, 256, 254, 251, 256, 254, 253, 255, 251, 251, 255}
	k := 10
	fmt.Println(minimumTimeRequired(jobs, k))
}
