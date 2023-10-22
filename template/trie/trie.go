package trie

type Trie struct {
	Chs  [26]*Trie
	Word string //default empty string
}

func (t *Trie) Insert(word string) {
	node := t
	for _, ch := range word {
		ch -= 'a'
		if node.Chs[ch] == nil {
			node.Chs[ch] = &Trie{}
		}
		node = node.Chs[ch]
	}
	node.Word = word
}

func (t *Trie) SearchPrefix(prefix string) *Trie {
	node := t
	for _, ch := range prefix {
		ch -= 'a'
		if node.Chs[ch] == nil {
			return nil
		}
		node = node.Chs[ch]
	}
	return node
}

func (t *Trie) Search(word string) bool {
	node := t.SearchPrefix(word)
	return node != nil && node.Word != ""
}

func (t *Trie) StartsWith(prefix string) bool {
	return t.SearchPrefix(prefix) != nil
}
