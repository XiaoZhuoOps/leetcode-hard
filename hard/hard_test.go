package hard

import (
	. "code.byted.org/gopkg/mockito"
	. "github.com/smartystreets/goconvey/convey"
	"testing"
)

func TestHardTest(t *testing.T) {
	PatchConvey("test", t, func() {
		Convey("lc224", func() {
			s := "(1+(4+5+2)-3)+(16+8)+17"
			ans := lc224_2(s)
			So(ans, ShouldEqual, 50)
		})
	})
}
