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
  Array canMove = Array.new(8)
  Array index = [0, 1, 2, 3, 4, 5, 6, 7]
  Integer i = 0
  Integer count = 0
  while i < canMove.length
    canMove[i] = knight.canMoveCount(i)
    if canMove[i] < 0 then
       canMove[i] = 9;
    else
      count = count + 1
    end
    i = i + 1
  end
  i = 0
  Integer j = 0
  Integer c = 0
  Integer min = 0
  while i < canMove.length
    j = i
    min = i
    while j < canMove.length
      if canMove[min] > canMove[j] then
        min = j
      end
      j = j + 1
    end
    c = canMove[min]
    canMove[min] = canMove[i]
    canMove[i] = c
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