program demonstration;
var count: integer;
var sum: integer;
var arr: array[1..5] of integer;

begin
    sum := 0;
    count := 1;
    
    while count <= 5 do
    begin
        arr[count] := count * 10;
        sum := sum + arr[count];
        count := count + 1
    end;
    
    writeln(sum);
    
    if sum > 100 then
        writeln(1)
    else
        writeln(0)
end.
