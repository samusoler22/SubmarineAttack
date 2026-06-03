# CLAUDE.md

This file provides guidance to Claude Code (claude.ai/code) when working with code in this repository.

## Project

**Submarine Attack** — a Java Swing game built as a university OOP assignment (UADE Q3 - POO). No build tool (no Maven/Gradle); it is a plain IntelliJ IDEA project. Source root is `src/`, compiled output goes to `out/production/Submarine Attack/`.

## Running the project

**From IntelliJ IDEA:** Open the project and run `Main.java` directly (the module is already configured in `Submarine Attack.iml`).

**From the command line** (run from the `Submarine Attack/` directory):

```powershell
# Compile
javac -d "out/production/Submarine Attack" src/Main.java src/GUI/TitleScreen.java src/Models/Embarcacion.java src/Models/CargaDeProfundidad.java src/Models/Barco.java src/Models/Submarino.java src/Models/Serie.java

# Run (resources/ is loaded relative to the working directory)
java -cp "out/production/Submarine Attack" Main
```

The background image is loaded via a relative path (`resources/kitten.jpg`), so the working directory must be `Submarine Attack/` when running.

There are no tests and no linter configured.

## Architecture

### Entry point

`Main` → `new TitleScreen()`. Everything starts from the title screen.

### Package layout

| Package | Role |
|---------|------|
| `GUI`   | Swing UI (currently only `TitleScreen`) |
| `Models`| Game domain objects |

### Domain model hierarchy

```
Embarcacion  (abstract)
├── Barco        — surface ship; fires CargaDeProfundidad objects
└── Submarino    — player/enemy submarine; takes damage from charges
```

**`Embarcacion`** holds `vivo`, `velocidad`, `posicionX`, `posicionY` and `movimientoHorizontal()` (increments X by velocity each tick).

**`Submarino`** adds vertical movement clamped to 300–800 m depth. Damage from a `CargaDeProfundidad` is resolved via `distanciaConCarga()` (Euclidean distance) → `calcularDanio()`: >100 m = 0 dmg, 50–100 m = 30, 10–50 m = 50, ≤10 m = 100 (instant kill). `recibirDanio()` sets `vivo = false` when `vida` reaches 0.

**`CargaDeProfundidad`** falls straight down (`caer()` increments `posicionY` by `velocidadCaida` each tick); `explotarCarga()` sets `exploto = true` once `posicionY >= profundidadDetonacion` (randomly chosen between 300–700 m at launch time). Its `posicionX` is `final` — it never drifts horizontally.

**`Barco`** maintains a `List<CargaDeProfundidad>` and fires charges from its own X position at a randomly computed depth via `DispararCargaDeProfundidad()`.

**`Serie`** manages a wave of ships: at most 3 active (`CAPACIDAD_MAXIMA`) out of 12 total (`TOTAL_BARCOS_SERIE`). `checkearBarcos()` is the main update hook — it recomputes active count, backfills slots, and calls `serieCompleta()`. A series is complete when all 12 ships have been added and none are alive. Call `reiniciarSerie()` to reset for the next round.

### Known issue

`Serie.agregarBarco()` calls `new Barco()` (no-arg constructor) but `Barco` only defines `Barco(int velocidad, int posicionX, int posicionY)` — this will not compile until either a no-arg constructor is added to `Barco` or `agregarBarco()` is updated to pass initial values.
