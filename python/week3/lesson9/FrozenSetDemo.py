def main():

    salary_by_skills = {
        frozenset({"Python", "SQL"}): 80000,
        frozenset({"Python", "Java"}): 85000,
        frozenset({"Python", "SQL", "Machine Learning"}): 100000
    }

    candidate_skills = frozenset(
        {"SQL", "Python", "Machine Learning"}
    )

    salary = salary_by_skills.get(candidate_skills, 0)

    print("Candidate skills:", candidate_skills)
    print("Estimated salary:", salary)

    required_skills = frozenset({"Python", "SQL"})

    print(
        "Meets basic requirements:",
        required_skills.issubset(candidate_skills)
    )

    additional_skills = candidate_skills - required_skills

    print("Additional skills:", additional_skills)


if __name__ == "__main__":
    main()