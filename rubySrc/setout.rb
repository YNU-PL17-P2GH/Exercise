require "stringio"

def getStdOut()
  return $stdout.string
end

def setStringOut()
  $stdout = StringIO.new
end

def setStdOut()
  $stdout = STDOUT
end
