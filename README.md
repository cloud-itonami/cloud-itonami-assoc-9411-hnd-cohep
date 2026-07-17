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

Unlike Panama's CONEP and Guatemala's CACIF (both blocked with HTTP
403), COHEP's own official site (`cohep.org`) was directly readable
this tick. Its `/quienes-somos/acerca/` page confirms a 1967 founding
(year-only precision), independently corroborated by `ceib.info`
(identical phrasing) and `es.wikipedia.org`, which additionally
supplies a precisely-dated milestone: COHEP opened a regional office
in San Pedro Sula on 24 July 2025.

## Scope

A **read-only reference/archive** catalog — not an Advisor⊣Governor
actuation actor. It proposes or executes nothing on COHEP's behalf.

Coverage is reported honestly (see `association.facts/coverage`): an
association not in `catalog` has **no spec-basis**, full stop — never
fabricate one.

## Data

- `src/association/facts.cljc` — the catalog, source of truth.
- `schema/association-rule.edn` — DataScript schema.
- `data/datascript-tx.edn` — derived DataScript tx-data (query this
  alongside other `cloud-itonami`/`etzhayyim` compliance-fact sources via
  `com-junkawasaki/root`'s `scripts/compliance-fact-query.cljs`).

## License

AGPL-3.0-or-later (matches the `cloud-itonami-iso3166-*` /
`-municipality-*` / `-assoc-*` / `-lei-*` convention).
