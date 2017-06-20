def search(array, target)
  Integer left = 0
  Integer mid = -1
  Integer right = array.length()
  while left <= right
    mid  = (left + right) / 2

    if array.checkElement(mid, target) == 0 then
      array.setResult(mid)
      break
    elsif array.checkElement(mid, target) == -1 then
      right = mid - 1
    elsif array.checkElement(mid, target) == 1 then
      left = mid + 1
    end
  end
end