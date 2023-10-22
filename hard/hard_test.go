package hard

import (
	"github.com/xiaozhuoops/leetcode/hard/Lc224"
	"testing"
)

func TestHardTest(t *testing.T) {
	PatchConvey("test", t, func() {
		Convey("lc224", func() {
			s := "(1+(4+5+2)-3)+(16+8)+17"
			ans := Lc224.lc224_2(s)
			So(ans, ShouldEqual, 50)
		})
	})
}
