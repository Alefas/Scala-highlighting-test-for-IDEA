package scl4560

import scalax.file.Path

object ResolutionTest {
  def test( path: Path ) = path / "ham.txt"

  class Test( root: Path ) {
    val child = root / "eggs.txt"
  }

  def main( args: Array[ String ] ) {
    val root = new Test( Path.createTempDirectory() )
    test( root.child )    // <-- root.child is highlighted with error "Type mismatch, expected: Path, actual: Any"
  }
}