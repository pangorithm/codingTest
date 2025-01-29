$env:RUST_BACKTRACE="full"
$input = Get-Content .\input.txt -Encoding UTF8 | Out-String
echo $input | cargo run