def tour(knight)
  tourSub(knight, 0)
end

def tourSub(knight, n)
  if n == 24 then
    return true
  end
  Integer i = 0
  while i < 8
    if knight.move(i) then
      if tourSub(knight, n + 1) then
        return true
      else
        knight.backtrack(i)
      end
    end
    i = i + 1
  end
  return false
end