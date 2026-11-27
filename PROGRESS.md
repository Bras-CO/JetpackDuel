# Jetpack Duel – Progress

**Team:** Grupo dos Fixes
**Git master:** Joel
**Last update:** 27 Nov 2026

---

## 🎮 The game (MVP)

A 1v1 duel. You only move **up and down**: hold a key to fly up, let go to fall.
The opponent (a bot) throws projectiles at you, and you have to dodge them.
**Click** to "shoot" back for small damage. Power-ups spawn sometimes, and grabbing them deals damage or gives you a buff.
First one to 0 HP loses.

The **UML diagram** is our contract: class names, fields and methods should match it.

---

## ✅ Done

**Project setup**
- IntelliJ project on **Java 17**
- SimpleGraphics jar in `lib/`, added as a dependency
- `.gitignore`: personal IDE files are ignored, shared `.idea` settings are committed (so the jar works for everyone)

**Package structure** (`com.grupodosfixes.jetpackduel`)
- `characters` – Character, Player, Opponent
- `effects` – StatusEffect
- `input` – GameKeyboard, GameMouse
- `objects` – Bullet, Projectile, PowerUp, Collidable, CollisionDetector
- `types` – all enums
- `ui` – Arena, HUD, SoundManager
- root – Game, Main

Every class file already exists (most are still empty).

**Finished**
- **Enums**
  - `EffectType`: ON_FIRE, SHOCKED, SHIELDED, IMMOBILIZED, SLOWED, EMPOWERED, plus `isNegative()`
  - `ProjectileType`: FLAME, BOULDER, LIGHTNING, ICE_BALL, each with damage, speed, effect and effect seconds, plus `randomProjectile()`
  - `PowerType`: FLAME, ARMOR, LIGHTNING_STRIKE, HEART, each with damage, heal, armor, effect and effect seconds, plus `randomPower()`
  - `GameState`: MENU, PLAYING, GAME_OVER
- **`Collidable`** interface: `getX()`, `getY()`, `getWidth()`, `getHeight()` (used for AABB collisions)
- **`Character`** (abstract, implements Collidable)
  - Fields, constructor and getters are done
  - Everyone starts at `MAX_HP = 100`
  - Method bodies are still empty: `takeDamage`, `heal`, `isDead`, `applyEffect`, `updateEffects`, `clearNegativeEffects`, `hasEffect`
  - `update()` is abstract, so Player and Opponent each write their own

⚠️ **Heads-up:** `HEART` has `effect = null` (healing is instant, not over time). Check `effect != null` before applying a power's effect, or you'll get a NullPointerException.

💡 Damage and speed numbers in the enums are **placeholders**. We'll balance them once the game runs.

 - Keep all damage values the same, powers deal 10 damage, single hits deal 1 damage, we balance after the game is running.

---

## ⏭️ Next – Phase 1: the core loop

Pick a task, tell the group, and work on your own branch.

- [ ] **Game loop + Arena + GameState:** game starts, background draws, the loop runs
- [ ] **Player + GameKeyboard:** hold a key to fly up, release it to fall, stay inside the arena
- [ ] **Opponent + Projectile:** the bot moves and throws projectiles on a cooldown
- [X] **CollisionDetector + HUD + SoundManager:** AABB hit detection, HP bars, music - (Joel)

🎯 **Milestone 1:** the player flies, the bot throws, and getting hit lowers your HP.

**Later:** Bullet + GameMouse (shooting), StatusEffect logic, PowerUp spawning, menus and game-over screen, music hookup, JAR packaging.

---

## 🛠️ Setup (first time)

1. Clone the repo
2. Open the project folder in IntelliJ
3. If you see a yellow bar saying **"Setup SDK"**, pick **Java 17**
4. If the SimpleGraphics imports are red: **File → Project Structure → Modules → Dependencies → + → JARs or Directories** → pick `lib/simple-graphics-0.2.2-SNAPSHOT.jar`

---

## 📏 Team rules

- **Never push directly to `main`**
- **One feature = one branch:** `feature/<what-it-does>` (e.g. `feature/player-movement`)
- **Always branch off an up-to-date `main`:** `git checkout main` → `git pull` → `git checkout -b feature/...`
- **Open a PR when you're done** and ask someone to review it
- **Never approve your own PR**
- **Commit often**, with clear messages
- **Don't rewrite or delete someone else's code without talking to them first**
- **Don't change project settings** (SDK, libraries) without telling the group
- Follow this week's **code conventions**
