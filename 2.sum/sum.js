/* sum.js */
// Sum Range

function sumRange(num)
{
  let sum = 0n;
  for (let i = 1n; i <= num; i++)
  {
    sum += i;
  }
  return sum;
}

function show(userInput)
{
  let num = parseInt(userInput);
  if (isNaN(num))
  {
    console.log("Input Error.");
    process.exit(-1);
  }
  let result = sumRange(num);
  console.log(`Result: ${result}`);
}

if (process.argv.length <= 2)
{
  let reader = (require("readline")).createInterface({input: process.stdin, output: process.stdout});
  reader.question("Enter Range\n", function (answer) {
    show(answer);
    reader.close();
  });
}
else
{
    show(process.argv[2]);
}
