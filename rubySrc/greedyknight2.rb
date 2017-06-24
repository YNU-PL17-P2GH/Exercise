def tour(knight)
  tourSub(knight, 0)
end

def tourSub(knight, n)
  if n ==99 then
    return true
  end
  Array nextJumps = getNextJumps(knight)
  Integer i = 0
  while i < nextJumps.length
    if knight.canMove(nextJumps[i]) then
      knight.move(nextJumps[i])
      if tourSub(knight, n + 1) then
        return true
      else
        knight.backtrack(nextJumps[i])
      end
    end
    i = i + 1
  end
  return false
end

def getNextJumps(knight)
  Array canMoves = Array.new(8)
  Array index = [0, 1, 2, 3, 4, 5, 6, 7]
  Integer i = 0
  Integer j = 0
  Integer count = 0
  while i < canMoves.length
    if knight.canMove(i) then
      knight.move(i)
      canMoves[i] = 0;
      j = 0
      count = count + 1
      while j < canMoves.length
        if knight.canMove(j) then
          canMoves[i] = canMoves[i] + 1
        end
        j = j + 1
      end
      knight.backtrack(i)
    else
      canMoves[i] = 9;
    end
    i = i + 1
  end
  i = 0
  j = 0
  Integer c = 0
  Integer min = 0
  while i < canMoves.length
    j = i
    min = i
    while j < canMoves.length
      if canMoves[min] > canMoves[j] then
        min = j
      end
      j = j + 1
    end
    c = canMoves[min] 
    canMoves[min] = canMoves[i]
    canMoves[i] = c
    c = index[min]
    index[min] = index[i]
    index[i] = c 
    i = i + 1
  end
  Array nextJump = Array.new(count)
  i = 0
  while i < nextJump.length
    nextJump[i] = index[i]
    i = i + 1
  end
  return nextJump
end