(ns association.facts
  "Industry rule/history catalog for COHEP (Consejo Hondureño de la
  Empresa Privada) -- a 74th industry-association-level source (see
  cloud-itonami-assoc-9411-sau-fsc, -9411-aut-wko, -9411-irl-ibec,
  -9411-nzl-businessnz, -9411-cze-spcr, -9411-ind-cii, -9411-zaf-busa,
  -9411-bra-cni, -9411-ken-kam, -9411-can-chamber, -9411-mex-coparmex,
  -9411-ita-confindustria, -9411-nld-vnoncw, -9411-kor-kcci,
  -9411-arg-uia, -9411-bel-feb, -9411-dnk-di, -9411-swe-sn, -9411-fin-ek,
  -9411-tha-fti, -9411-chl-sofofa, -9411-col-andi, -9411-cri-uccaep,
  -9411-ecu-cip, -9411-egy-fei, -9411-pry-uip, -9411-ury-ciu,
  -9411-pol-lewiatan, -9411-prt-cip, -9411-pan-conep, -9411-gtm-cacif
  for the first thirty-one) per ADR-2607141700 (cloud-itonami-
  compliance-fact-federation). The THIRTY-SECOND entry aligned to
  ISIC 9411 (activities of business, employers, and professional
  membership organizations). Fills Honduras's previously-open
  association-axis gap -- the LAST of the 5 countries (GTM/HND/PAN/
  POL/PRT) that closed their municipality-axis gap in ticks 163-167 to
  reach association-only-missing status. Honduras now has real,
  individually verified facts across ALL THREE axes (country:
  cloud-itonami-iso3166-hnd statute.facts, pre-existing; municipality:
  cloud-itonami-municipality-hnd-tegucigalpa, added tick 167;
  association: this entry). This closes the entire 5-country arc
  opened after tick 167's full country/municipality structural-gap
  closure -- every one of GTM/HND/PAN/POL/PRT now has real,
  individually verified facts across all 3 axes.

  Unlike Panama's CONEP (tick 170) and Guatemala's CACIF (tick 171),
  where the official site returned HTTP 403 Forbidden, COHEP's own
  official site (cohep.org) WAS directly readable this tick. Its
  '/quienes-somos/acerca/' page states verbatim: 'El Consejo
  Hondureño de la Empresa Privada, COHEP es una institución sin fines
  de lucro fundada en 1967' (year-only precision on the official page
  itself). Independently corroborated by ceib.info, which repeats the
  identical phrasing verbatim (mirroring COHEP's own self-
  description). es.wikipedia.org's own article corroborates the 1967
  founding year in its infobox ('Fundación: 1967') and additionally
  supplies a precisely-dated, day-level milestone not found on
  COHEP's own page: 'El 24 de julio de 2025 abrió una sede regional
  en San Pedro Sula' (COHEP opened a regional office in San Pedro
  Sula on 24 July 2025).

  An association not in `catalog` has NO spec-basis, full stop; never
  fabricate one.")

(def catalog
  "association-slug -> vector of association-rule entries."
  {"cohep"
   [{:association-rule/id "cohep.founding-1967"
     :association-rule/title "COHEP (Consejo Hondureño de la Empresa Privada) founded 1967 (cohep.org's own official page, independently corroborated by ceib.info and es.wikipedia.org)"
     :association-rule/association "cohep"
     :association-rule/isic "9411"
     :association-rule/country "HND"
     :association-rule/kind :governance-program
     :association-rule/url "https://www.cohep.org/quienes-somos/acerca/"
     :association-rule/url-provenance :official-cohep-org
     :association-rule/established-date "1967"
     :association-rule/retrieved-at "2026-07-18"
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
     :association-rule/retrieved-at "2026-07-18"
     :association-rule/topic #{:governance}}]})

(defn spec-basis [association] (get catalog association))

(defn coverage
  ([] (coverage (keys catalog)))
  ([associations]
   (let [have (filter catalog associations)
         missing (remove catalog associations)]
     {:requested (count associations)
      :covered (count have)
      :covered-associations (vec (sort have))
      :missing-associations (vec (sort missing))
      :note (str "cloud-itonami-assoc-9411-hnd-cohep Wave 0 (ADR-2607141700): "
                 (count (get catalog "cohep")) " COHEP entries seeded "
                 "with cohep.org official page + ceib.info + es.wikipedia.org corroboration. "
                 "Extend `association.facts/catalog`, never fabricate an id/url.")})))

(defn by-topic [association topic]
  (filterv #(contains? (:association-rule/topic %) topic) (spec-basis association)))
