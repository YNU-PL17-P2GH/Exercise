def nqueen(queen)
	Array direct = [[-1, -1], [0, -1], [1, -1]]
	Array board = Array.new(8){Array.new(8, 0)}
	Array place = Array.new(8){Array.new(2)}
  Array answer = []
	nqueenSub(direct, board, place, 0, answer)
	Integer i = 0

	#とりあえず一つだけ
	while i < answer[0].length()
		#print(answer[1][i][0], " ", answer[1][i][1], "\n")
		queen.putQueen(answer[1][i][0], answer[1][i][1])
		i = i + 1
	end

end

def nqueenSub(direct, board, place, n, answer)
	if place.length() == n then
	  Array a = Array.new(8){Array(2)}
	  Integer k = 0
	  while k < 8
	    a[k][0] = place[k][0]
	    a[k][1] = place[k][1]
	    k = k + 1
	  end
    answer << a
		return
	end
	Integer i = 0
	Integer j = 0
	Integer x = 0
	Integer y = n
	while j < 8
		i = 0
		while i < 3
			y = n
			x = j + direct[i][0]
			y = n + direct[i][1]
			while x >= 0 && x < board[0].length() && y >= 0
				if board[y][x] == 1 then
					break
				end
				x = x + direct[i][0]
				y = y + direct[i][1]
			end
			if y >= 0 && x >= 0 && x < board[0].length() then
				break
			end
			i = i + 1
		end
		if x < 0 || x >= board[0].length() || y < 0 then
			#print(j ," ", n, "\n")
			board[n][j] = 1
			place[n][0] = j
			place[n][1] = n
			#p board
			#sleep 2
			nqueenSub(direct, board, place, n + 1, answer)
			board[n][j] = 0
		end
		j = j + 1
	end
	#p n
	return
end