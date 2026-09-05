# cloud-itonami-assoc-9411-hnd-cohep

Industry rule/history catalog for **COHEP** (Consejo Hondureño de la
Empresa Privada) — the THIRTY-SECOND entry aligned to **ISIC 9411**
(activities of business, employers, and professional membership
organizations), alongside
[`-9411-gtm-cacif`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-gtm-cacif)
(Guatemala),
[`-9411-pan-conep`](https://github.com/cloud-itonami/cloud-itonami-assoc-9411-pan-conep)
(Panama), and 30 other national industry/employers associations.
Part of the [`cloud-itonami`](https://github.com/cloud-itonami)
compliance-fact family (ADR-2607141700,
`cloud-itonami-compliance-fact-federation`, in `com-junkawasaki/root`).

Fills the **last** of the 5 countries (GTM/HND/PAN/POL/PRT) that
closed their municipality-axis gap in ticks 163-167. Honduras now has
real, individually verified facts across **all three axes** (country,
municipality, association) — closing the entire 5-country arc opened
after tick 167's full country/municipality structural-gap closure.

## Sourcing note

COHEP's own site (`cohep.org`) is directly readable — unlike Panama's
CONEP and Guatemala's CACIF, both of which answered HTTP 403 — so most
of this catalog is COHEP citing itself. Every URL in the catalog was
fetched and read on its `:retrieved-at` date.

What the catalog records is the **delegation chain**, not just a
founding year: the Statutes make the Code of Ethics binding on members
(art. 12), send the admission/suspension procedure to a Board
regulation (art. 10), require the Board to issue six named instruments
(art. 51), and supply the sanctions that back them (art. 49 — written
reprimand, temporary suspension, definitive suspension).

**The site contradicts itself, and the catalog says so.** The Statutes
date Executive Resolution 99 to *5 May 1967*; the membership page dates
the same resolution to *8 May 1967*. Both readings are carried as
separate entries with separate URLs, and the second is filed under
`:official-cohep-org-conflicting` so it is not counted as a clean
official citation. Do not "tidy" this by deleting one — the
disagreement is the fact. `es.wikipedia.org` corroborates the 1967
founding year and supplies one day-level milestone the official pages
do not (a regional office opened in San Pedro Sula on 24 July 2025).

Personal names are deliberately absent. The Junta Directiva page names
every officer; this catalog records the *shape* of the board (seats,
terms, renewal) and not who sits on it.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on COHEP's behalf.

Coverage is reported honestly (see `association.facts/coverage`): an
association not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/association/facts.cljc` — the catalog, hand-authored, source of truth.
- `data/datascript-tx.edn` — the same catalog as DataScript tx-data (query
  it alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).
- `src/association_facts.kotoba` — the Kotoba port, which reaches the
  Kotoba oracle, wasm and both native ISAs. **Generated** — run
  `nbb tools/gen_kotoba.cljs` after changing the data; do not hand-edit.
- `schema/association-rule.edn` — DataScript schema.

The `.cljc` is written by hand and the `.kotoba` is generated from the
`.edn`, so `test/association_facts_kotoba_parity_test.clj` compares two
independently produced faces of the same facts. That independence is
the only reason the comparison means anything — do not "simplify" it by
generating both from one source.

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention).
