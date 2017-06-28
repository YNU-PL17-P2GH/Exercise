def solve(labyrinth)
  Array map = labyrinth.getMap()
  Array start = labyrinth.getStartPos()
  Array goal = labyrinth.getGoalPos()
  map[start[1]][start[0]] = 'S'
$Gmap = Array.new(map.length){Array.new(map[0].length, ' ')}
  Array heap = []
  Array element = Array.new(3)
  element[0] = start[0]
  element[1] = start[1]
  element[2] = distance(goal, start[0], start[1])
  push(heap, element)
  p solveSub(heap, map, goal)

  Integer ii = 0
  Integer jj = 0
  while ii < map.length
    jj = 0
    while jj < map[0].length
      print(map[ii][jj].chr("UTF-8"))
      jj = jj + 1
    end
    print("\n")
    ii = ii + 1
  end
  
ii = 0
  jj = 0
  while ii < map.length
    jj = 0
    while jj < map[0].length
      print($Gmap[ii][jj])
      jj = jj + 1
    end
    print("\n")
    ii = ii + 1
  end

end

def solveSub(heap, map, goal)
    Array direct = [[1, 0], [-1, 0], [0, 1], [0, -1]]
    Array directC = ['L', 'R', 'U', 'B']
    Integer x = 0
    Integer y = 0
    Integer i = 0
    while heap.length != 0
      element = pop(heap)
      $Gmap[element[1]][element[0]] = 'V'
      #p element
      i = 0
      while i  < direct.length
        x = element[0] + direct[i][0]
        y = element[1] + direct[i][1]
        #p x, y
        if x < 0 || x >= map[0].length || y < 0 || y >= map.length then
          i = i + 1
          next
        end
        if map[y][x] != 32 then
          i = i + 1
          next
        end
        map[y][x] = directC[i]
        Array newElement = Array.new(3)
        newElement[0] = x
        newElement[1] = y
        newElement[2] = distance(goal, x, y)
        if newElement[2] == 0 then
          return true
        end
        push(heap, newElement)
        i = i + 1
      end
      p heap
    end
    return false
end

def distance(goal , x, y)
  return ((goal[0] - x) * (goal[0] - x)  + (goal[1] - y) * (goal[1] - y))
end

def push(heap, values)
  heap << values
  Integer pos = heap.length - 1

  while pos > 0
    if(heap[(pos - 1) / 2][2] <= values[2]) then
      break
    end
    Array t = heap[(pos - 1) / 2]
    heap[(pos - 1) / 2] = heap[pos]
    heap[pos] = t
    pos = (pos - 1) / 2
  end
end

def pop(heap)
  Array result = heap[0]
  heap[0] = heap[heap.length - 1]
  heap.delete_at(heap.length - 1)

  Integer pos = 0
  Integer left = 10000 #十分に大きい数字
  Integer right = 10000

  while pos < heap.length

    if pos * 2 + 1 < heap.length then
      left = heap[pos * 2 + 1][2]
    else
      left = 10000
    end
    if pos * 2 + 2 < heap.length then
      right = heap[pos * 2 + 2][2]
    else
      right = 10000
    end
    Array t = []
    if heap[pos][2] < left && heap[pos][2] < right then
      break
    end

    if left < right then
      t = heap[pos]
      heap[pos] = heap[pos * 2 + 1]
      heap[pos * 2 + 1] = t
      pos = pos * 2 + 1
    else
      t = heap[pos]
      heap[pos] = heap[pos * 2 + 2]
      heap[pos * 2 + 2] = t
      pos = pos * 2 + 2
    end
  end

  return result
end