def hanoi(tower, n)
	hanoiSub(tower, 1, 0, 2, n)
end

def hanoiSub(tower, from, to, relay, n)
	if n > 0 then
		hanoiSub(tower, from, relay, to, n - 1)
		tower.move(from, to)
		hanoiSub(tower, relay, to, from, n - 1)
	end
end