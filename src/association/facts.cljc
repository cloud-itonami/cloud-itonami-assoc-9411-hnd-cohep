(ns association.facts
  "Industry rule/history catalog for COHEP (Consejo Hondureño de la
  Empresa Privada) per ADR-2607141700 (cloud-itonami-compliance-fact-
  federation), aligned to ISIC 9411 (activities of business, employers,
  and professional membership organizations). Honduras has real,
  individually verified facts across all three axes -- country:
  cloud-itonami-iso3166-hnd statute.facts; municipality:
  cloud-itonami-municipality-hnd-tegucigalpa; association: this entry.

  WHAT IS ACTUALLY HERE. COHEP's self-regulation is not one document.
  The Statutes delegate: art. 51 requires the Board to issue six
  instruments, art. 10 sends the admission/suspension/withdrawal
  procedure to a Board regulation, art. 12 makes the Code of Ethics
  binding on members, and art. 49 supplies the sanctions that back it.
  The catalog records that chain, not just the founding year.

  PROVENANCE, by tier -- read `:association-rule/url-provenance`, not
  the title, when you need to know how far a fact has been checked:

  - `:official-cohep-org` -- COHEP's own publication at cohep.org,
    including the two Code of Ethics PDFs it serves. Fetched and read
    2026-09-06.
  - `:wikipedia-corroborated` -- the San Pedro Sula office entry. Kept
    on this tier because it is a day-level date that COHEP's own pages
    do not state, so there is no official source to promote it to.
  - `:official-cohep-org-conflicting` -- COHEP's own site, contradicted
    by COHEP's own site. Exactly one entry: the Statutes date Executive
    Resolution 99 to 5 May 1967 and the membership page dates the same
    resolution to 8 May 1967. BOTH are recorded, on separate entries
    with separate urls, rather than one of them silently chosen. Do not
    'fix' this by deleting an entry; the disagreement is the fact.

  Personal names are deliberately absent. The Junta Directiva page
  names every officer; `organization.edn` records institutional office
  titles only, and this catalog keeps to the same rule -- which is why
  the board entry records the SHAPE of the board (seats, terms,
  renewal) and not who sits on it.

  An association not in `catalog` has NO spec-basis, full stop; never
  fabricate one.")

(def catalog
  "association-slug -> vector of association-rule entries."
  {"cohep"
   [{:association-rule/id "cohep.founding-1967"
     :association-rule/title "COHEP describes itself as founded in 1967 (its own Acerca page)"
     :association-rule/association "cohep"
     :association-rule/isic "9411"
     :association-rule/country "HND"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.cohep.org/quienes-somos/acerca/"
     :association-rule/url-provenance :official-cohep-org
     :association-rule/established-date "1967"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance}}
    {:association-rule/id "cohep.san-pedro-sula-office-2025-07-24"
     :association-rule/title "COHEP opened a regional office in San Pedro Sula on 24 July 2025"
     :association-rule/association "cohep"
     :association-rule/isic "9411"
     :association-rule/country "HND"
     :association-rule/kind :governance-program
     :association-rule/url "https://es.wikipedia.org/wiki/Consejo_Hondure%C3%B1o_de_la_Empresa_Privada"
     :association-rule/url-provenance :wikipedia-corroborated
     :association-rule/established-date "2025-07-24"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance}}
    {:association-rule/id "cohep.codigo-etica-transparencia-integridad"
     :association-rule/title "Codigo de Etica, Transparencia e Integridad — COHEP's anti-corruption good-practice framework for member organisations"
     :association-rule/association "cohep"
     :association-rule/isic "9411"
     :association-rule/country "HND"
     :association-rule/kind :code-of-ethics
     :association-rule/url "https://www.cohep.org/codigo-etica/"
     :association-rule/url-provenance :official-cohep-org
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:ethics :governance}}
    {:association-rule/id "cohep.codigo-etica-pdf-es"
     :association-rule/title "Codigo de Etica (Spanish), the instrument itself as published by COHEP — 20-page PDF"
     :association-rule/association "cohep"
     :association-rule/isic "9411"
     :association-rule/country "HND"
     :association-rule/kind :code-of-ethics
     :association-rule/url "https://www.cohep.org/descargar/148/link-directo/11750/codigo-etica-esp-cohep.pdf"
     :association-rule/url-provenance :official-cohep-org
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:ethics}}
    {:association-rule/id "cohep.codigo-etica-pdf-en"
     :association-rule/title "Code of Ethics (English), COHEP's own translation of the same instrument — 20-page PDF"
     :association-rule/association "cohep"
     :association-rule/isic "9411"
     :association-rule/country "HND"
     :association-rule/kind :code-of-ethics
     :association-rule/url "https://www.cohep.org/descargar/148/link-directo/11752/codigo-etica-eng-cohep.pdf"
     :association-rule/url-provenance :official-cohep-org
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:ethics}}
    {:association-rule/id "cohep.estatutos-art-1-resolution-99"
     :association-rule/title "Statutes art. 1: COHEP recognised as a legal person by Executive Resolution 99, dated 5 May 1967 on the statutes page"
     :association-rule/association "cohep"
     :association-rule/isic "9411"
     :association-rule/country "HND"
     :association-rule/kind :statute
     :association-rule/url "https://www.cohep.org/quienes-somos/estatutos/"
     :association-rule/url-provenance :official-cohep-org
     :association-rule/established-date "1967-05-05"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance}}
    {:association-rule/id "cohep.afiliacion-resolution-99-conflicting-date"
     :association-rule/title "The membership page dates the same Executive Resolution 99 to 8 May 1967 — COHEP's own site gives two days for one resolution"
     :association-rule/association "cohep"
     :association-rule/isic "9411"
     :association-rule/country "HND"
     :association-rule/kind :statute
     :association-rule/url "https://www.cohep.org/nuestros-miembros/como-afiliarse/"
     :association-rule/url-provenance :official-cohep-org-conflicting
     :association-rule/established-date "1967-05-08"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance}}
    {:association-rule/id "cohep.estatutos-art-1-ilo-convention-87"
     :association-rule/title "Statutes art. 1: COHEP is constituted under ILO Convention 87 and is independent of government, workers' organisations and political parties"
     :association-rule/association "cohep"
     :association-rule/isic "9411"
     :association-rule/country "HND"
     :association-rule/kind :statute
     :association-rule/url "https://www.cohep.org/quienes-somos/estatutos/"
     :association-rule/url-provenance :official-cohep-org
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance :labor}}
    {:association-rule/id "cohep.estatutos-reforma-2017"
     :association-rule/title "Statutes in force are the reform issued at Tegucigalpa on 19 October 2017 (file PJ-13092017-600), abrogating the statutes approved by Resolution 80-2013"
     :association-rule/association "cohep"
     :association-rule/isic "9411"
     :association-rule/country "HND"
     :association-rule/kind :statute
     :association-rule/url "https://www.cohep.org/quienes-somos/estatutos/"
     :association-rule/url-provenance :official-cohep-org
     :association-rule/established-date "1967-05-05"
     :association-rule/last-revised-date "2017-10-19"
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance}}
    {:association-rule/id "cohep.estatutos-art-12-member-obligations"
     :association-rule/title "Statutes art. 12: members must comply with the Statutes, the Code of Ethics, the regulations and the resolutions of the Assembly and the Board, and pay their dues"
     :association-rule/association "cohep"
     :association-rule/isic "9411"
     :association-rule/country "HND"
     :association-rule/kind :membership-rule
     :association-rule/url "https://www.cohep.org/quienes-somos/estatutos/"
     :association-rule/url-provenance :official-cohep-org
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:membership :ethics}}
    {:association-rule/id "cohep.estatutos-art-49-regimen-sancionador"
     :association-rule/title "Statutes art. 49: the Board may sanction members and officers for breaches of the Statutes, Code of Ethics and regulations — written reprimand, temporary suspension, definitive suspension"
     :association-rule/association "cohep"
     :association-rule/isic "9411"
     :association-rule/country "HND"
     :association-rule/kind :sanctions-regime
     :association-rule/url "https://www.cohep.org/quienes-somos/estatutos/"
     :association-rule/url-provenance :official-cohep-org
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:enforcement :ethics}}
    {:association-rule/id "cohep.estatutos-art-51-board-issued-instruments"
     :association-rule/title "Statutes art. 51: the Board issues six instruments, among them the Code of Ethics and the regulation on admission, re-admission, suspension and withdrawal of members"
     :association-rule/association "cohep"
     :association-rule/isic "9411"
     :association-rule/country "HND"
     :association-rule/kind :statute
     :association-rule/url "https://www.cohep.org/quienes-somos/estatutos/"
     :association-rule/url-provenance :official-cohep-org
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance :ethics}}
    {:association-rule/id "cohep.estatutos-art-26-27-junta-directiva"
     :association-rule/title "Statutes arts. 26-27: an eighteen-seat Board, two-year terms renewable once, half the seats renewed each year, and no more than one representative of any single member"
     :association-rule/association "cohep"
     :association-rule/isic "9411"
     :association-rule/country "HND"
     :association-rule/kind :statute
     :association-rule/url "https://www.cohep.org/quienes-somos/estatutos/"
     :association-rule/url-provenance :official-cohep-org
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:governance}}
    {:association-rule/id "cohep.afiliacion-requisitos"
     :association-rule/title "Seven documents are required to apply for COHEP membership, including proof of registration with the civil-association registry URSAC"
     :association-rule/association "cohep"
     :association-rule/isic "9411"
     :association-rule/country "HND"
     :association-rule/kind :membership-rule
     :association-rule/url "https://www.cohep.org/nuestros-miembros/como-afiliarse/"
     :association-rule/url-provenance :official-cohep-org
     :association-rule/retrieved-at "2026-09-06"
     :association-rule/topic #{:membership}}]})

(defn spec-basis [association] (get catalog association))

(defn- provenance-tier
  "Which of the tiers in the namespace docstring this entry sits on.

  `:conflicting` is tested BEFORE `^official-`, because the conflicting entry's
  provenance also starts with `official-`. Ordering it the other way would count
  a contradiction as a clean official citation -- which is the one thing the
  tier is here to prevent."
  [entry]
  (let [p (name (:association-rule/url-provenance entry))]
    (cond (re-find #"conflicting$" p)   :conflicting
          (= p "wikipedia-corroborated") :corroborated
          (re-find #"self-declared$" p)  :self-declared
          (re-find #"^official-" p)      :official
          :else                          :unknown)))

(defn note-for
  "The coverage note, COMPUTED from the catalog rather than written beside it.

  Written notes drift: a hand-written count stays at the number it was written
  with while entries are added around it. Deriving the counts means adding an
  entry changes this string, and the parity test then requires the port to be
  regenerated with it."
  [association]
  (let [entries (get catalog association)
        n       (count entries)
        tally   (frequencies (map provenance-tier entries))
        cnt     #(get tally % 0)]
    (str "cloud-itonami-assoc-9411-hnd-cohep Wave 0 (ADR-2607141700): "
         n " COHEP entries -- "
         (cnt :official) " from COHEP's own publication, "
         (cnt :corroborated) " Wikipedia-corroborated, "
         (cnt :conflicting) " contradicted by another page of COHEP's own site. "
         "Extend `association.facts/catalog`, never fabricate an id/url.")))

(defn coverage
  ([] (coverage (keys catalog)))
  ([associations]
   (let [have (filter catalog associations)
         missing (remove catalog associations)]
     {:requested (count associations)
      :covered (count have)
      :covered-associations (vec (sort have))
      :missing-associations (vec (sort missing))
      :note (note-for "cohep")})))

(defn by-topic [association topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis association)))
