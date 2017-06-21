def tour(knight)
  Array array = Array.new(35)
  tourSub(knight, array, 0)
end

def tourSub(knight, array, n)
  if n ==35 then
    return true
  end
  Integer i = 0
  while i < 8
    if knight.move(i) then
      array[n] = i
      if tourSub(knight, array, n + 1) then
        return true
      else
        array[n] = -1
        knight.backtrack(i)
      end
    end
    i = i + 1
  end
  return false
end