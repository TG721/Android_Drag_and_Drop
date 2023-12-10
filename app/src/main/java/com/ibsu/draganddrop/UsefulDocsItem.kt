package com.ibsu.draganddrop

data class UsefulDocsItem(
    val id: Int,
    val nameEn: String,
    val nameGe: String
)

val documentList = listOf(
    UsefulDocsItem(
        id = 1,
        nameEn = "Academic Calendar",
        nameGe = "აკადემიური კალენდარი",
    ),
    UsefulDocsItem(
        id = 2,
        nameEn = "Bachelor Thesis Cover Page (Georgian Sector)",
        nameGe = "საბაკალავრო ნაშრომის თავფურცელი (ქართული სექტორი)",
    ),
    UsefulDocsItem(
        id = 3,
        nameEn = "Bachelor Thesis Cover Page (English Sector)",
        nameGe = "საბაკალავრო ნაშრომის თავფურცელი (ინგლისური სექტორი)",
    ),
    UsefulDocsItem(
        id = 4,
        nameEn = "Instructions for Bachelor Thesis (English Sector)",
        nameGe = "საბაკალავრო ნაშრომის ინსტრუქციები (ინგლისური სექტორი)",
    ),
    UsefulDocsItem(
        id = 5,
        nameEn = "Instructions for Bachelor Thesis (Georgian Sector)",
        nameGe = "საბაკალავრო ნაშრომის ინსტრუქციები (ქართული სექტორი)",
    ),
    UsefulDocsItem(
        id = 6,
        nameEn = "Internship Instructions (English Sector)",
        nameGe = "სტაჟირების ინსტრუქცია (ინგლისური სექტორი)",
    ),
    UsefulDocsItem(
        id = 7,
        nameEn = "Internship Instructions (Georgian Sector)",
        nameGe = "სტაჟირების ინსტრუქცია (ქართული სექტორი)",
    ),
    UsefulDocsItem(
        id = 8,
        nameEn = "Request to participate in the exchange program",
        nameGe = "გაცვლით პროგრამაში მონაწილეობის მოთხოვნა",
    )
)
