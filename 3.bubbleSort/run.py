import os

commands = ["@echo off && cls", 
  "javac -encoding UTF-8 bubblesort\Program.java && java bubblesort.Program", 
  "gcc Bubblesort.c -o BubbleSort.out.exe && BubbleSort.out.exe", 
  "csc -nologo -parallel BubbleSort.cs && BubbleSort.exe", 
  "node BubbleSort.js", 
  "python BubbleSort.py"]

for cmd in commands:
  os.system(cmd)

print("done")
