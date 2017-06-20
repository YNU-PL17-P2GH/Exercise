def search(array, target)
  Integer i = 0
  while i < array.length()
    if array.checkElement(i, target) == 0 then
      array.setResult(i)
      break
    end
    i = i + 1
  end
end